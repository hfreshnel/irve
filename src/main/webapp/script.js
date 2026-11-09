
// Get page URL
const origin = window.location.origin;
const serverEndPoint = origin +  "/carte_des_borne_electrique/ma-carte";
// Initialiser la carte
    var mymap = L.map('map');
    var markers = [];
	const markersMap = new Map();
	
    // Ajouter la couche OpenStreetMap à la carte
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(mymap);

    // Ajouter un marqueur à un emplacement spécifique
    //L.marker([51.5, -0.09]).addTo(mymap)
    //  .bindPopup('Un exemple de marqueur sur la carte.');
      
    // Appeler la fonction pour ajuster la hauteur de la carte au chargement de la page et lors du redimensionnement de la fenÃªtre
	setMapHeight();
	window.addEventListener('resize', setMapHeight);
      
     // Vérifier si le navigateur prend en charge la géolocalisation
 if (navigator.geolocation) {
     // Demander la position gÃ©ographique actuelle
     navigator.geolocation.getCurrentPosition(updateMapLocation, handleLocationError);
 } else {
     // Le navigateur ne prend pas en charge la géolocalisation
     console.error("La géolocalisation n'est pas prise en charge par ce navigateur.");
 }
 

 // Appeler la fonction pour récupérer les données du serveur
//fetchDataFromServer();
      
function setMapHeight() {
    let windowHeight = window.innerHeight; // Récupére la hauteur de la fenêtre en pixel
    let mapElement = document.getElementById('map'); //RÃ©cupére le composant à partir de son id qui est map
    mapElement.style.height = windowHeight + 'px';
}

 // Fonction pour gérer les erreurs de géolocalisation
 function handleLocationError(error) {
     console.error("Erreur de géolocalisation : ", error.message);
 }
 
  function updateMapLocation(position) {
     var latitude = position.coords.latitude;
     var longitude = position.coords.longitude;

     // Mettre à jour la carte avec la nouvelle position
     mymap.setView([latitude, longitude], 13);

     // Ajouter un marqueur à la position
    L.marker([latitude, longitude]).addTo(mymap)
         .bindPopup("Vous etes ici").openPopup();
 }
 
 // Définir la fonction pour récupérer les données du serveur
function fetchDataFromServer() {
  var xhr = new XMLHttpRequest();
  xhr.open('GET', serverEndPoint, true);
  xhr.onload = function() {
    if (xhr.status >= 200 && xhr.status < 300) {
      // Succès de la requête
      var responseData = JSON.parse(xhr.responseText);
      // Traitement des données récupérées du serveur
      alert(" 1");
      alert(xhr.responseText);
    } else {
      // Erreur lors de la requête
      document.getElementById("test").innerHTML = 'Erreur lors de la récupération des données du serveur:'+ xhr.statusText;
    }
  };
  xhr.onerror = function() {
    document.getElementById("test").innerHTML = 'Erreur lors de la récupération des données du serveur.';
  };
  xhr.send();
}

const freeCB = document.getElementById('checkbox1');
const roue2CB = document.getElementById('checkbox2');
const publicCB = document.getElementById('checkbox3');
const h24 = document.getElementById('checkbox4');
function getCheckboxState() {
    const state = {
        option1: freeCB.checked,
        option2: roue2CB.checked,
        option3: publicCB.checked,
        option4: h24.checked
    };
    return state;
}
function setMarkers(listIRVE){
	let showIr = true;
	markersMap.clear;
	markers.forEach(function (marker) {
            mymap.removeLayer(marker);
    });
    const checkboxState = getCheckboxState();
	listIRVE.forEach(function(irve){
		if(checkboxState.option1 && !irve.tarification.toUpperCase().includes("GRATUIT"))
			showIr = false;
		if(checkboxState.option2 && !irve.deuxRoues)
			showIr = false;
		if(checkboxState.option3 && !irve.implantation.toUpperCase().includes("PUBLIC"))
			showIr = false;
		if(checkboxState.option4 && !irve.horaire.includes("24/7")){
			showIr = false;
			console.log(irve.horaire);
		}
			
		if(showIr){
			var lat = irve.latitude;
			var lon = irve.longitude;
			var name = irve.nom;
			var irMark = L.marker([lat, lon]).addTo(mymap)
	         .bindPopup(name).openPopup();
	        markersMap.set(irMark, irve);
	        markers.push(irMark);
		}
		
	})
	// Ajouter un écouteur d'événement "click" à chaque marqueur
	markers.forEach(function(marker) {
	    marker.on('click', function(event) {
	        document.getElementById('infostation').style.visibility = "visible";
	        document.getElementById('adresse').innerHTML = markersMap.get(marker).adresse;
	        document.getElementById('contactOperateur').innerHTML = markersMap.get(marker).contact;
	        document.getElementById('horaire').innerHTML = markersMap.get(marker).horaire;
	        document.getElementById('nomStation').innerHTML = markersMap.get(marker).nom;
	    });
	});
}

//fetch
async function getIRVE(searchPatter) {
    try {
        const response = await fetch(serverEndPoint, {
            method: 'post',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: "%"+searchPatter+"%"
        });
        if (!response.ok) {
            throw new Error("HTTP error, status = " + response.status);
        }
        
        let responseData;
        
        // Vérifie le type de contenu de la réponse
        const contentType = response.headers.get('content-type');
        
        if (contentType && contentType.includes('application/json')) {
            // Si la réponse est au format JSON, utilise response.json()
            responseData = await response.json();
        } else {
            // Si la réponse n'est pas au format JSON, utilise response.text()
            responseData = await response.text();
        }

        // Traitement des données en fonction du type de contenu
        if (typeof responseData === 'string') {
            // Si la réponse est une chaîne de caractères (texte brut)
            console.log("Réponse: " + responseData);
        } else {
            // Si la réponse est au format JSON
            //console.log("Réponse: " + JSON.stringify(responseData));
            setMarkers(responseData.listIRVE);
        }

    } catch (error) {
        console.error("Fetch error:", error);
        // Affiche une alerte en cas d'erreur
        console.log("Une erreur est survenue: " + error.message);
    }
}



// Ajouter un événement pour afficher le niveau de zoom
map.addEventListener('zoomend', function () {
    var currentZoom = map.getZoom();
    console.log(currentZoom);
    var maxZoomToShowMarkers = 10; // Spécifiez ici le niveau de zoom maximum pour afficher les marqueurs
    
    // Parcourir tous les marqueurs et décider s'ils doivent être affichés ou masqués
    markers.forEach(function (marker) {
        if (currentZoom < maxZoomToShowMarkers) {
            marker.addTo(map);
        } else {
            map.removeLayer(marker);
        }
    });
});

// Récupérer la référence du bouton de recherche
var searchButton = document.getElementById('searchButton');

// Ajouter un écouteur d'événement pour l'événement click sur le bouton de recherche
searchButton.addEventListener('click', function() {
    // Récupérer le contenu de la balise input
    var contenu = document.getElementById('searchBarre').value;
    if(contenu.length > 2)
    	getIRVE(contenu);
    else
    	alert("Pas assez de caractère pour la recherche");
});



