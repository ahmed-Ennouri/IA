function chemin() {
	console.log('ready to send data');
	let pharmacie_source = document.getElementsByName("pharmacie-source")[0].value;
	let pharmacie_destination = document.getElementsByName("pharmacie-destination")[0].value;

	
	if (pharmacie_source && pharmacie_destination) {
		let params = {
			source: pharmacie_source,
			target: pharmacie_destination
		};

		
		ajax(pharmacie_source,pharmacie_destination)
	}
}

var xhr;

function ajax(source , target) {
	let url = 'Controller?source=' + source+'&target='+ target;
	xhr = new XMLHttpRequest();
	xhr.open('GET', url, true);
	xhr.onreadystatechange = callback;
	xhr.send();
}

function callback() {
	if (xhr.readyState == XMLHttpRequest.DONE) {
		if (xhr.status == 200) {
			
			console.log(xhr.responseText);
		}
	}
}