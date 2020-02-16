var map;
var infoWindow;


function createMap () {
	
	var a = 38.940652,
    b = 16.430850,
    diff = 0.0033;
	
	 var options = {
	    center: { lat: a, lng: b },
	    mapTypeId: 'satellite',
	    zoom: 18
	  };

  map = new google.maps.Map(document.getElementById('map'), options);
  infoWindow = new google.maps.InfoWindow;
  
  var position = {
    lat: 38.940652,
    lng: 16.430850
  };
  
  infoWindow.setPosition(position);
  infoWindow.setContent('Eccoci');
  infoWindow.open(map);
  map.setCenter(position);
  
  var input = document.getElementById('search');
  var searchBox = new google.maps.places.SearchBox(input);

  map.addListener('bounds_changed', function() {
    searchBox.setBounds(map.getBounds());
  });

  var markers = [];
  
  searchBox.addListener('places_changed', function () {
    var places = searchBox.getPlaces();

    if (places.length == 0)
      return;

    markers.forEach(function (m) { m.setMap(null); });
    markers = [];

    var bounds = new google.maps.LatLngBounds();
    places.forEach(function(p) {
      if (!p.geometry)
        return;

      markers.push(new google.maps.Marker({
        map: map,
        title: p.name,
        position: p.geometry.location
      }));

      if (p.geometry.viewport)
        bounds.union(p.geometry.viewport);
      else
        bounds.extend(p.geometry.location);
    });
    
    map.fitBounds(bounds);
  });
}  


