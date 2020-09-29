const list = document.querySelector('.fav_list');
const input = document.querySelector('.fav_input');
const button = document.querySelector('.fav_button');
const frequency = document.querySelector('#frequency');

const para = document.querySelector('.order_para')

const totop = document.querySelector('.totoppage');
const theme = document.querySelector('.dark');
const highcontrast = document.querySelector('.contrastmode');

const page = document.documentElement;
const body = document.querySelector('body');
const title = document.querySelector('h1');
const navigation = document.querySelectorAll('.linav');
const article = document.querySelector('article');
const form = document.querySelector('form');
const fieldset = document.querySelectorAll('fieldset');
const nav_box = document.querySelector('nav');
const links = document.querySelectorAll('a');


button.onclick = function(){
	let current = input.value;
	input.value = '';
	const list_item = document.createElement('li');
	const span = document.createElement('span');
	const delete_button = document.createElement('button');
	list_item.appendChild(span);
	span.textContent = current;
	list_item.appendChild(delete_button);
	delete_button.textContent="Delete";
	list.appendChild(list_item);

	delete_button.onclick=function(event){
	list.removeChild(list_item);
    }
input.focus();
}


frequency.addEventListener("change", setPrice);

function setPrice(){
	const choice = frequency.value;
	if(choice===""){
		para.textContent = "Please choose a frequency for the delivery.";
	}
	else if(choice==="Once"){
		para.textContent = "One delivery costs: £5";
	}
	else if(choice==="Daily"){
		para.textContent = "Daily delivery for one year costs: £1300";
	}
	else if(choice==="Weekly"){
		para.textContent = "Weekly delivery for one year costs: £200";
	}
	else if(choice==="Fortnightly"){
		para.textContent = "Fortnightly delivery for one year costs: £100";
	}
	else if(choice==="Monthly"){
		para.textContent = "Monthly delivery for one year costs: £50";
	}
	else if(choice==="Quarterly"){
		para.textContent = "Quarterly delivery for one year costs: £25";
	}
	else{
		para.textContent = "Something has gone wrong! Please refresh the page!";
	}
}

/* Dark mode buttons */



	// Selects the button 
totop.onclick = function(){//onclick run this function
	window.scrollTo({
	top:0,
	left:0,
	behaviour:'auto'});// recenteres the screen to the top left sets behaviour to determine how the scroll happens.
		
	}



theme.onclick = function(){
	if(theme.getAttribute("class")==="dark"){
		theme.setAttribute("class", "light");
		theme.textContent= "Light Mode";
		body.classList.toggle("darkmode");
		page.classList.toggle("darkmode");
		title.classList.toggle("darkmode");
		article.classList.toggle("darkmode");
		form.classList.toggle("darkmode");
		nav_box.classList.toggle("darkmode");
		
		for(let counter=0;counter<navigation.length;counter++){
			navigation[counter].classList.toggle("darkmode");
		}

		for(let counter=0;counter<fieldset.length;counter++){
			fieldset[counter].classList.toggle("darkmode");
		}

		for(let counter=0; counter<link.length;counter++){
			link[counter].classList.toggle("darkmodelink");
		}
	}

	else {
		theme.setAttribute("class", "dark");
		theme.textContent = "Dark Mode";
		body.classList.toggle("darkmode");
		page.classList.toggle("darkmode");
		title.classList.toggle("darkmode");
		article.classList.toggle("darkmode");
		form.classList.toggle("darkmode");
		nav_box.classList.toggle("darkmode");
		
		for(let counter=0;counter< navigation.length;counter++){
			navigation[counter].classList.toggle("darkmode");
		}

		for(let counter=0;counter<fieldset.length;counter++){
			fieldset[counter].classList.toggle("darkmode");
		}

		for(let counter=0; counter<link.length;counter++){
			link[counter].classList.toggle("darkmodelink");
		}
	}
}


highcontrast.onclick = function(){
	body.classList.toggle("highcontrastbody");
	page.classList.toggle("highcontrastpage");
	title.classList.toggle("highcontrastbody");
	article.classList.toggle("highcontrastbody");
	form.classList.toggle("highcontrastbody");
	nav_box.classList.toggle("highcontrastbody");
	for(let counter=0;counter<navigation.length;counter++){
		navigation[counter].classList.toggle("highcontrastbody");
	}

	for(let counter=0;counter<fieldset.length;counter++){
			fieldset[counter].classList.toggle("highcontrastbody");
		}

}



