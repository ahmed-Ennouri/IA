function chemin() {
	//console.log('ready to send data');
	let pharmacie_source = document.getElementsByName("pharmacie-source")[0].value;
	let pharmacie_destination = document.getElementsByName("pharmacie-destination")[0].value;
	if (pharmacie_source && pharmacie_destination) {
		let params = {
			source: pharmacie_source,
			target: pharmacie_destination
		};
		/*this.ajax.get('Project-IA/Controller', params, (response) => {
			let pharmacies = JSON.parse(response.text);
			console.log(pharmacies);
			let s = '<ol>';
			for (let a of authors) {
				s += '<li>' + a.name + '</li>';
			}
			s += '</ol>';
			this.result.innerHTML = s;
		});*/
	}
}