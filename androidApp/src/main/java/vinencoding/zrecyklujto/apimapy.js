var m = new SMap(JAK.gel("mapa"));
m.addControl(new SMap.Control.Sync());
m.addDefaultLayer(SMap.DEF_BASE).enable();
m.addDefaultControls();

var stred = SMap.Coords.fromWGS84(14.41, 50.08);
var mapa = new SMap(JAK.gel("mapa"), stred, 10);
mapa.addDefaultLayer(SMap.DEF_BASE).enable();
mapa.addDefaultControls();

function geokoduj(e, elm) {  /* Voláno při odeslání */
    JAK.Events.cancelDef(e); /* Zamezit odeslání formuláře */
    var query = JAK.gel("query").value;
    new SMap.Geocoder(query, odpoved);
}

function odpoved(geocoder) { /* Odpověď */
    if (!geocoder.getResults()[0].results.length) {
        alert("Tohle neznáme.");
        return;
    }

    var vysledky = geocoder.getResults()[0].results;
    var data = [];
    while (vysledky.length) { /* Zobrazit všechny výsledky hledání */
        var item = vysledky.shift()
        data.push(item.label + " (" + item.coords.toWGS84(2).reverse().join(", ") + ")");
    }
    alert(data.join("\n"));
}

var form = JAK.gel("form");
JAK.Events.addListener(form, "submit", geokoduj); /* Při odeslání formuláře pustit geokódování */

// pokrocile pouziti
document.querySelector("input.search-adv").addEventListener("click", function(e) {
	var geocode = new SMap.Geocoder(document.querySelector("#queryAdv").value, odpoved, {
    // parametry pro omezeni mista - bounding box ceske republiky dle https://wiki.openstreetmap.org/wiki/WikiProject_Czech_Republic
  	bbox: [SMap.Coords.fromWGS84(12.09, 51.06), SMap.Coords.fromWGS84(18.87, 48.55)]
  });
});