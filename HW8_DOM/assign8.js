
function getValues(){
	var name = document.getElementById('input-name').value;
	var object = document.getElementById('input-object').value;
	var adjective = document.getElementById('input-adjective').value;
	var verb = document.getElementById('input-verb').value;
	console.log('test');
	
	document.getElementById("storyTitle").innerHTML = name+"'s Madlib Story!";
	document.getElementById("storyContent").innerHTML = name+" woke up one day from a nightmare. They dreamed of " + object +" chasing them everywhere, wanting to "+verb+" them. "+name+" suddenly became afraid of "+object+" because of this. This nightmare really made them "+adjective+". As revenge, "+name+" decided to "+verb+" "+object+" back in real life!";
};