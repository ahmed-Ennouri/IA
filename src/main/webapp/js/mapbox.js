mapboxgl.accessToken = 'pk.eyJ1IjoiYW1uMDA5IiwiYSI6ImNrZ3FrN25nYjA1MXQycW1mc3Y2cnV4MGYifQ.HH70YXWvUre4p-ZTxjzV5A';
    const map = new mapboxgl.Map({
        container: 'map', // container ID
        style: 'mapbox://styles/amn009/cl30h98pf001215lzyk6hr5vc', // style URL
        center: [-5.000000, 34.033333], // starting position
        zoom: 14 // starting zoom
    });

    // Add geolocate control to the map.
    map.addControl(
        new mapboxgl.GeolocateControl({
            positionOptions: {
                enableHighAccuracy: true
            },
            // When active the map will receive updates to the device's location as it changes.
            trackUserLocation: true
        })
    );
    
    
    
    
/*
    //My coordinates
    let latitude;
    let longitude;
    
    function geoFindMe() {
    	
    	map.addSource('nearest-pharmacy', {
    	  	  type: 'geojson',
    	  	  data: {
    	  	    type: 'FeatureCollection',
    	  	    features: []
    	  	  }
    	    });

    	  function success(position) {
    	    latitude  = position.coords.latitude;
    	    longitude = position.coords.longitude;
    	    
    	 	/ Return any features from the 'libraries' layer whenever the map is clicked
    	    const pharmacyFeatures = map.queryRenderedFeatures({
    	      layers: ['fes-pharmacies']
    	    });
    	    if (!pharmacyFeatures.length) {
    	        return;
    	    }
    	    
    	    const pharmacyFeature = pharmacyFeatures[0];
    	    
    	 	// Using Turf, find the nearest hospital to library clicked
    	    const nearestPharmacy = turf.nearest(pharmacyFeature, hospitals);
    	    
    	  }

    	  function error() {
    	    console.log('Unable to retrieve your location');
    	  }

    	  if(!navigator.geolocation) {
    		  console.log('Geolocation is not supported by your browser');
    	  } else {
    	    navigator.geolocation.getCurrentPosition(success, error);
    	  }

    }

    map.on('load', geoFindMe);*/