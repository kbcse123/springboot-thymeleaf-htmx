if('webkitSpeechRecognition' in window ){
			 // Initialize webkitSpeechRecognition
		  let speechRecognition = new webkitSpeechRecognition();
          var searchCommand = document.querySelector("#searchCommand");
		  // String for the Final Transcript
		  let final_transcript = "";
		  // Set the properties for the Speech Recognition object
		  speechRecognition.continuous = true;
		  speechRecognition.interimResults = true;
		  //speechRecognition.lang = document.querySelector("#select_dialect").value;

           var startObj = document.querySelector("#startVoice");
           var stopObj = document.querySelector("#stopVoice");
		  // Set the onClick property of the start button
		  startObj.onclick = () => {
		  // Start the Speech Recognition
		    console.log('Speech recognition started.');
		    speechRecognition.start();
		  };
		  // Set the onClick property of the stop button
		  stopObj.onclick = () => {
			// Stop the Speech Recognition
			console.log('Speech recognition stopped.');
			speechRecognition.stop();
		  };

		  // Callback Function for the onStart Event
		  speechRecognition.onstart = () => {
			 searchCommand.innerHTML = "Voice Search Activated...."
			 startObj.style.display = "none";
             stopObj.style.display = "block";
		  };
		  speechRecognition.onerror = () => {
			searchCommand.innerHTML = "Error....";
			startObj.style.display = "block";
            stopObj.style.display = "none";
		  };
		  speechRecognition.onend = () => {
			startObj.style.display = "block";
            stopObj.style.display = "none";
			searchCommand.innerHTML = "Voice Search deactivated....";
		  };
          let interim_transcript = "";
		  speechRecognition.onresult = (event) => {
		  searchCommand.innerHTML = "";
		  final_transcript="";
          interim_transcript = "";
			// Create the interim transcript string locally because we don't want it to persist like final transcript
			var search_command = "";
			// Loop through the results from the speech recognition object.
			for (let i = event.resultIndex; i < event.results.length; ++i) {
			  // If the result item is Final, add it to Final Transcript, Else add it to Interim transcript
			  if (event.results[i].isFinal) {
				final_transcript += event.results[i][0].transcript;
			  } else {
				interim_transcript += event.results[i][0].transcript;
			  }
			  searchCommand.innerHTML = interim_transcript;
			}
			search_command = final_transcript.trim();
			//console.log("search_command: "+search_command);
            //console.log('final_transcript: '+final_transcript);
			// Set the Final transcript and Interim transcript.
			//document.querySelector("#searchFeeds").innerHTML = final_transcript;
			if (search_command != "") {
			searchCommand.innerHTML = search_command;
			    if(search_command == 'clear'
			    || search_command == 'okay clear'
                || search_command == 'back'
			    || search_command == 'go back'
			    || search_command == 'ok go back'
                || search_command == 'okay go back'){
			      //console.log("Clearing the input text ");
			      search_command="";
			    }else if(search_command.startsWith("reload")
			     || search_command.startsWith("refresh")){
                   location.reload();
                }else if(search_command.startsWith("search")){
                  search_command=search_command.replace("search","").trim();
                }else if(search_command.startsWith("find")){
                  search_command=search_command.replace("find","").trim();
                }else if(search_command.startsWith("show")){
                  if(search_command.includes("show me")){
                    search_command=search_command.replace("show me","").trim();
                  }else{
                    search_command=search_command.replace("show","").trim();
                  }
                }

                if(search_command.startsWith("delete") || search_command.startsWith("remove")){
                    //console.log("Inside Delete...");
                    var button = document.getElementsByTagName("button");
                    for (var i = 0; i < button.length; i++) {
                      //console.log("button value = "+button[i].innerHTML);
                      if (button[i].innerHTML.includes("Delete")) {
                        //console.log("Deleting...");
                        button[i].click();
                      }
                    }
                }else if(search_command.startsWith("load")){
                     search_command="";
                     //console.log("loading...");
                     document.querySelector("#loadMore").click();
                }else {
			        document.querySelector("#searchFeeds").value = search_command;
			        htmx.trigger("#searchFeeds", "input");
			    }
			}

		  };

	} else {
		  console.log("Speech Recognition Not Available")
	}