leaflet_integrated_leaflet_connector = function () {
   var connector = this;
   var element = connector.getElement();

   element.innerHTML = "<div id=\"map\" style=\"width: 600px; height: 400px;\"></div>";

	const map = L.map('map').setView([47.20486, 7.54290], 13);

	const tiles = L.tileLayer('https://stamen-tiles.a.ssl.fastly.net/watercolor/{z}/{x}/{y}.jpg', {
		maxZoom: 19,
		attribution: '&copy; Map tiles by <a href="http://stamen.com">Stamen Design</a>, under <a href="http://creativecommons.org/licenses/by/3.0">CC BY 3.0</a>. Data by <a href="http://openstreetmap.org">OpenStreetMap</a>, under <a href="http://creativecommons.org/licenses/by-sa/3.0">CC BY SA</a>'
	}).addTo(map);

	var fc = {
        "type": "FeatureCollection",
        "features": [
            {
                "type": "Feature",
                "id": "Bade",
                "properties": null,
                "geometry": {
                    "type": "Point",
                    "coordinates": [8.00193, 47.37921]
                }
            },
            {
                "type": "Feature",
                "id": "Tschutte",
                "properties": null,
                "geometry": {
                    "type": "Point",
                    "coordinates": [7.93602, 47.36170]
                }
            }
        ]
    }

    function featureClicked(feature){
        if(feature.id)
            alert(feature.id)
    }

    function onEachFeature(feature, layer) {
        layer.on('click', function () {
          featureClicked(feature)
        });
    }

	var fl = L.geoJSON(null, {onEachFeature: onEachFeature}).addTo(map);
	fl.addData(fc);

	map.fitBounds(fl.getBounds());

	$(window).on("resize", function() {
        $("#leaflet").height($(window).height()).width($(window).width());
        map.invalidateSize();
    }).trigger("resize");
};