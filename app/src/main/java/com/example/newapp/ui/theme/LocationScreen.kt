package com.example.newapp.ui.theme

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.os.Looper
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.newapp.Screen
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import android.Manifest
import androidx.annotation.RequiresPermission
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun LocationScreen(navController: NavHostController, context: Context = LocalContext.current) {
    val locationText = remember { mutableStateOf("Fetching location...") }
    val permissionGranted = remember { mutableStateOf(false) }
    val gpsEnabled = remember { mutableStateOf(false) }
    val locationFetched = remember { mutableStateOf(false) }

    // GPS resolution launcher
    val gpsLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult()
    ) { result ->
        if (result.resultCode == android.app.Activity.RESULT_OK) {
            gpsEnabled.value = true
        } else {
            locationText.value = "Please enable GPS to fetch location"
        }
    }

    // Permission launcher
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val fineGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true
        val coarseGranted = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
        permissionGranted.value = fineGranted || coarseGranted
    }

    // Request location permissions on first launch
    LaunchedEffect(Unit) {
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }

    // Check GPS settings and fetch location
    fun checkGPSAndFetchLocation() {
        val locationRequest = LocationRequest.create().apply {
            priority = Priority.PRIORITY_HIGH_ACCURACY
        }

        val settingsRequest = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)
            .setAlwaysShow(true)
            .build()

        val settingsClient = LocationServices.getSettingsClient(context)
        settingsClient.checkLocationSettings(settingsRequest)
            .addOnSuccessListener {
                gpsEnabled.value = true
            }
            .addOnFailureListener { e ->
                if (e is ResolvableApiException) {
                    val intentSenderRequest = IntentSenderRequest.Builder(e.resolution).build()
                    gpsLauncher.launch(intentSenderRequest)
                } else {
                    locationText.value = "GPS not available"
                }
            }
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    @SuppressLint("MissingPermission")
    fun fetchLocation() {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

        val locationRequest = LocationRequest.create().apply {
            priority = Priority.PRIORITY_HIGH_ACCURACY
            interval = 0
            fastestInterval = 0
            numUpdates = 1
        }

        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            object : LocationCallback() {
                override fun onLocationResult(result: LocationResult) {
                    val loc: Location? = result.lastLocation
                    if (loc != null) {
                        locationText.value = "Lat: ${loc.latitude}, Long: ${loc.longitude}"
                        locationFetched.value = true
                    } else {
                        locationText.value = "Location not found"
                    }
                    fusedLocationClient.removeLocationUpdates(this)
                }
            },
            Looper.getMainLooper()
        )
    }

    // Logic controller
    LaunchedEffect(permissionGranted.value, gpsEnabled.value) {
        if (permissionGranted.value && !gpsEnabled.value) {
            checkGPSAndFetchLocation()
        }
        if (permissionGranted.value && gpsEnabled.value && !locationFetched.value) {
            fetchLocation()
        }
    }

    // UI
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(150.dp)) // Push content down
        Text(
            text = locationText.value,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Button(
            onClick = {
                // Save location in Firestore
                val firestore = FirebaseFirestore.getInstance()
                val locationData = hashMapOf(
                    "latitude" to locationText.value.substringAfter("Lat: ").substringBefore(",").toDouble(),
                    "longitude" to locationText.value.substringAfter("Long: ").toDouble(),
                    "timestamp" to System.currentTimeMillis()
                )

                firestore.collection("location")
                    .add(locationData)
                    .addOnSuccessListener {
                        navController.navigate(Screen.SignIn.route) {
                            popUpTo(Screen.Location.route) { inclusive = true }
                        }
                    }
                    .addOnFailureListener { e ->
                        // Optionally show a Toast or log error
                        locationText.value = "Failed to store location: ${e.message}"
                    }
            },
            enabled = locationFetched.value
        ) {
            Text("Continue")
        }
    }
}
