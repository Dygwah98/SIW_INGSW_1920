<!DOCTYPE html>
<html class="full" lang="en">
<head>
    <title>Google Calendar API</title>
    <link href="styles/bootstrap.min.css" rel="stylesheet" />
    <link href="styles/Calendar.css" rel="stylesheet" />
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js"></script>
	
    <script type="text/javascript">
        // date variables
        
        var now = new Date();
        today = now.toISOString();

        var twoHoursLater = new Date(now.getTime() + (2 * 1000 * 60 * 60));
        twoHoursLater = twoHoursLater.toISOString();

        // Google api console clientID and apiKey 
        var clientId = '';
        var apiKey = 'AIzaSyCtcP0f-pfqYcfAZR1H_cSopbVpv79ETwI';

        // enter the scope of current project (this API must be turned on in the Google console)
        var scopes = 'https://www.googleapis.com/auth/calendar';

        // OAuth2 functions
        function handleClientLoad() {
            gapi.client.setApiKey(apiKey);
            window.setTimeout(checkAuth, 1);
        }

        function checkAuth() {
            gapi.auth.authorize({ client_id: clientId, scope: scopes, immediate: true }, handleAuthResult);
        }

        // show/hide the 'authorize' button, depending on application state
        function handleAuthResult(authResult) {
            var authorizeButton = document.getElementById('authorize-button');
            var eventButton = document.getElementById('btnCreateEvents');
            var resultPanel = document.getElementById('result-panel');
            var resultTitle = document.getElementById('result-title');

            if (authResult && !authResult.error) {
                authorizeButton.style.visibility = 'hidden'; 		// if authorized, hide button
                resultPanel.className = resultPanel.className.replace(/(?:^|\s)panel-danger(?!\S)/g, '')	// remove red class
                resultPanel.className += ' panel-success'; 			// add green class
                resultTitle.innerHTML = 'Application Authorized'		// display 'authorized' text
                eventButton.style.visibility = 'visible';
                $("#txtEventDetails").attr("visibility", "visible");
            } else {													// otherwise, show button
                authorizeButton.style.visibility = 'visible';
                $("#txtEventDetails").attr("visibility", "hidden");
                eventButton.style.visibility = 'hidden';
                resultPanel.className += ' panel-danger'; 			// make panel red
                authorizeButton.onclick = handleAuthClick; 			// setup function to handle button click
            }
        }

        // function triggered when user authorizes app
        function handleAuthClick(event) {
            gapi.auth.authorize({ client_id: clientId, scope: scopes, immediate: false }, handleAuthResult);
            return false;
        }

        function refreshICalendarframe() {
            var iframe = document.getElementById('divifm')
            iframe.innerHTML = iframe.innerHTML;
        }
        // setup event details
        
        // function load the calendar api and make the api call
        function makeApiCall() {
            var eventResponse = document.getElementById('event-response');
           
            gapi.client.load('calendar', 'v3', function () {					// load the calendar api (version 3)
                var request = gapi.client.calendar.events.insert
                ({
                    'calendarId': 'riuzaki9797@gmail.com', // calendar ID
                    "resource": resource							// pass event details with api call
                });
                
                // handle the response from our api call
                request.execute(function (resp) {
                    if (resp.status == 'confirmed') {
                        eventResponse.innerHTML = "Event created successfully. View it <a href='" + resp.htmlLink + "'>online here</a>.";
                        eventResponse.className += ' panel-success';
                        refreshICalendarframe();
                    } else {
                        document.getElementById('event-response').innerHTML = "There was a problem. Reload page and try again.";
                        eventResponse.className += ' panel-danger';
                    }
                });
            });
        }
        var resource = {
            "summary": "My Event",
            "description":"We are organizing events",
            "location":"US",
			"start": {
                "dateTime": today
            },
            "end": {
                "dateTime": twoHoursLater
            },
            "attendees":[
			{
					"email":"riuzaki9797@gmail.com",
					"displayName":"Shaveta",
					"organizer":true,
					"self":true,
					"resource":true,
					"optional":true,
					"responseStatus":"needsAction",
					"comment":"This is event first",
					"additionalGuests":3
					
			},
			{	
				"email":"riuzaki9797@gmail.com",
					"displayName":"Chatak",
					"organizer":true,
					"self":true,
					"resource":true,
					"optional":true,
					"responseStatus":"needsAction",
					"comment":"This is office event",
					"additionalGuests":3
			}
			],
		};

		// FUNCTION TO DELETE EVENT
	   function deleteEvent() {
		 gapi.client.load('calendar', 'v3', function() {  
		   var request = gapi.client.calendar.events.delete({
			 'calendarId': 'riuzaki9797@gmail.com',
			 'eventId': 'Hdusrtsbs8'
		   });
		 request.execute(function(resp) {
			if (resp.status == 'confirmed') {
				alert("Event was successfully removed from the calendar!");
			}
			else{
				alert('An error occurred, please try again later.')
			}
		 });
		 });
	   } 
 

		</script>
    <script src="https://apis.google.com/js/client.js?onload=handleClientLoad" type="text/javascript"></script>
</head>
<body>
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Google Calendar API</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">Simple Way to embed you calendar</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-2 col-sm-2 col-xs-12">
                <button id="authorize-button" style="visibility: hidden" class="btn btn-primary">
                    Authorize</button>
            </div>
            <!-- .col -->
            <div class="col-md-10 col-sm-10 col-xs-12">
                <div class="panel panel-danger" id="result-panel">
                    <div class="panel-heading">
                        <h1>
                            My Calendar</h1>
                        <h3 class="panel-title" id="result-title">
                            Application Not Authorized</h3>
                        &nbsp;
                        <p>
                            Insert Event into Public Calendar&hellip;</p>
                    </div>
                </div>
                       <!--  <input id="txtEventDetails" type="text" /> -->
                <button id="btnCreateEvents" class="btn btn-primary" onclick="makeApiCall();">
                    Create Events</button>  
				<button id="btnDeleteEvents" class="btn btn-primary" onclick="deleteEvent();">
                    Delete Events</button> 					
                <div id="event-response">
                </div>
                <div id="divifm">
<iframe src="https://calendar.google.com/calendar/embed?src=riuzaki9797%40gmail.com&ctz=Europe%2FRome" style="border: 0; border-style: none" width="800" height="600"></iframe></div>
            </div>
        </div>
    </div>
</body>
</html>
