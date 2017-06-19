function impostaFormLogin() {
	var form = document.createElement("form");
	form.className = "navbar-form";
	form.setAttribute("th:action", "@{/login}");
	form.method = "post";

	var div = creaDiv("form-group form-inline");
	div.appendChild(creaInput("form-control", "text", "username", "username", null));
	div.appendChild(creaInput("form-control", "password", "password", "password", null));
	div.appendChild(creaInput("form-control", "submit", "login", null, "login"));

	form.appendChild(div);

	var container =	document.getElementById("form-container");
	container.innerHTML = "";
	container.appendChild(form);
}

function creaDiv(className) {
	var div = document.createElement("div");
	div.className = className;
	return div;
}

function creaLabel(innerHTML) {
	var label = document.createElement("label");
	label.innerHTML = innerHTML;
	return label;
}

function creaInput(className, type, name, placeholder, value) {
	var input = document.createElement("input");
	input.className = className;
	input.type = type;
	input.name = name;
	if(placeholder != null)
		input.placeholder = placeholder;
	if(value != null)
		input.value = value;

	return input;
}