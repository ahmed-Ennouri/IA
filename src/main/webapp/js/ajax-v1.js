var xhr;

function ajax() {
	let name = document.getElementById('name').value;
	let url = 'biblio/sarch-authors?name=' + name;
	xhr = new XMLHttpRequest();
	xhr.open('GET', url, true);
	xhr.onreadystatechange = callback;
	xhr.send();
	
	xhr.status;
	xhr.readyState;
	xhr.responseText;
	xhr.responseXML;
}

function callback() {
	if (xhr.readyState == XMLHttpRequest.DONE) {
		if (xhr.status == 200) {
			document.getElementById('result').innerHTML = xhr.responseText;
		}
	}
}