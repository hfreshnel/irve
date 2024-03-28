<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>OpenStreetMap</title>
  <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css" />
  <link rel="stylesheet" href="style.css" />
  <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
   <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.5.1/leaflet.js'></script>
</head>
<body>
	<p id="test"></p>
	<div id="inputetimagerecherche" style="position: relative;width: 30%;display: flex;align-items: center;margin-bottom: 25px;">
		<svg id="searchButton" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" height="20px" width="20px" style="position: absolute;right: 15px;"><!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.--><path d="M416 208c0 45.9-14.9 88.3-40 122.7L502.6 457.4c12.5 12.5 12.5 32.8 0 45.3s-32.8 12.5-45.3 0L330.7 376c-34.4 25.2-76.8 40-122.7 40C93.1 416 0 322.9 0 208S93.1 0 208 0S416 93.1 416 208zM208 352a144 144 0 1 0 0-288 144 144 0 1 0 0 288z"/></svg>
		<input id="searchBarre" placeholder="Rechercher" type="text" style="border: none;background-color: rgb(245,245,245);border-radius: 15px;width: 100%;text-align: center;font-size: 18px;padding: 3px 0 3px 0">
	</div>
	<svg style="position: absolute;right: 15px;top: 10px;" xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="blue" class="bi bi-filter-circle-fill" viewBox="0 0 16 16"> <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zM3.5 5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1 0-1zM5 8.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm2 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 0 1h-1a.5.5 0 0 1-.5-.5z"/> </svg>
  
  	<div id="map"></div>
  	 <div class="checkbox-container">
	 	<div style="display: flex;margin-bottom: 25px;justify-content: flex-start;">
		 	<label for="checkbox1">Gratuite</label>
	        <input type="checkbox" id="checkbox1" name="option1">
		 </div>
        
        <div style="display: flex;margin-bottom: 25px;justify-content: flex-start;">
        	<label for="checkbox2">Station deux roues</label>
        	<input type="checkbox" id="checkbox2" name="option2">
        </div>
        <div style="display: flex;margin-bottom: 25px;justify-content: flex-start;">
        	<label for="checkbox3">Parking public</label>
        	<input type="checkbox" id="checkbox3" name="option3">
        </div>
        <div style="display: flex;margin-bottom: 25px;justify-content: flex-start;">
        	<label for="checkbox4">h24</label>
        	<input type="checkbox" id="checkbox4" name="option4">
        </div>
        </div>
    </div>
    
    <div id="infostation">
    	<div id="nomStation" style="font-size: 25px;border-bottom: 1px solid lightgray;padding: 10px;text-align: center;margin-bottom: 10px;font-weight: bold;">ZUNDER</div>
    	
    	<div id="adresse" style="font-size: 25px;border-bottom: 1px solid lightgray;padding: 10px;text-align: center;margin-bottom: 10px;">Av. des Canadiens, 76800 Saint-Etienne-du-Rouvray</div>
    	
    	<div id="contactOperateur" style="font-size: 25px;border-bottom: 1px solid lightgray;padding: 10px;text-align: center;margin-bottom: 10px;">roaming@zunder.com</div>
    	
    	<div id="horaire" style="font-size: 25px;border-bottom: 1px solid lightgray;padding: 10px;text-align: center;margin-bottom: 10px;">24h/7J</div>
    </div>

  <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
  <script type='text/javascript' src='script.js'></script>
</body>
</html>
