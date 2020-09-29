const displayedImage = document.querySelector('.displayed-img');
const thumbBar = document.querySelector('.thumb-bar');

const displayed_menu_img = document.querySelector('.displayed_menu_img');
const menu_thumb_bar = document.querySelector('.menu_thumb_bar');
const para = document.querySelector('.menu_para');
const menu = document.querySelector('.Menu');

const text = {text1:"Freshly baked biscuits! £3.50 for 4", text2:"Handmade Sandwiches available in a range of flavours £4.00", text3:"Delectable Opera Cake £8.00", text4:"Delicious cakes made daily on site! £3.00 a slice",text5:"Baked Cheese Cake £4.50 a slice"}

const to_top = document.querySelector('.go_to_top');

/* Looping through images */

for(let counter = 1; counter <= 5; counter++){
	const newImage = document.createElement('img');
	newImage.setAttribute('src',"Images/pic"+counter+".jpg");
	thumbBar.appendChild(newImage);
	newImage.onclick =function(event){
	displayedImage.src = event.currentTarget.src;
	}
}

for(let counter = 1; counter <= 5; counter++){
	const new_menu_Image = document.createElement('img');
	new_menu_Image.setAttribute('src',"Images/menu_pic"+counter+".jpg");
	menu_thumb_bar.appendChild(new_menu_Image);
	new_menu_Image.onclick =function(event){
	displayed_menu_img.src = event.currentTarget.src;

	if (displayed_menu_img.src.includes("1")) {
		para.textContent=text.text1;
	}
	else if (displayed_menu_img.src.includes("2")){
		para.textContent=text.text2;
	}
	else if (displayed_menu_img.src.includes("3")) {
		para.textContent=text.text3;
	}
	else if (displayed_menu_img.src.includes("4")){
		para.textContent=text.text4;
	}
	else if (displayed_menu_img.src.includes("5")){
		para.textContent=text.text5;
	}
	else
		para.textContent="Something has gone wrong!";
	}
}

to_top.onclick= function(){
	window.scrollTo({
		top:0,
		left:0,
		behaviour:'smooth'
	});
}
