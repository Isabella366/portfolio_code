const displayedImage = document.querySelector('.displayed-img');
const thumbBar = document.querySelector('.thumb-bar');

const totop = document.querySelector('.toTop');

const alt =["Hardwood seating in a room with exposed brick.","A person makes coffee behind a counter.","Kettles boiling on a gas stove.", "Long wooden tables with a cup of coffee on it.", "Coffee being extruded from a machine."]

for(let counter = 1; counter <= 5; counter++){
	const newImage = document.createElement('img');
	newImage.setAttribute('src',"Images/pic"+counter+".jpg");
	newImage.setAttribute('alt', alt[counter]);
	thumbBar.appendChild(newImage);
	newImage.onclick =function(event){
	displayedImage.src = event.currentTarget.src;
	}
}

totop.onclick = function(){//onclick run this function
	window.scrollTo({
	top:0,
	left:0,
	behaviour:'auto'});// recenteres the screen to the top left sets behaviour to determine how the scroll happens.
		
	}