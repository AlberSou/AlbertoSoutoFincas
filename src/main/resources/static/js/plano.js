//Recocgemos el parametro de la url
const params = new URLSearchParams(window.location.search);
const idfinca = params.get("idfinca");
//Funcion para recoger la url de la id finca para obtener los arboles
async function recogerDatos() {
	const response = await fetch(`http://localhost:8080/fincas/plano/${idfinca}`);
	const data = await response.json();
	sacarDatos(data);
}
//Función para sacar los datos, los arboles
function sacarDatos(data) {
	const contenedor = document.querySelector(".contenedor");
	contenedor.innerHTML = "";
	contenedor.style.display = "grid";

	let maxColumna = 0;
	let maxFila = 0;

	// Obtener los valores máximos de fila y columna
	for (let tam of data) {
		if (tam.columna > maxColumna) {
			maxColumna = tam.columna;
		}
		if (tam.fila > maxFila) {
			maxFila = tam.fila;
		}
	}
	// Crear las celdas de la cuadrícula
	for (let fila = 1; fila <= maxFila; fila++) {
		for (let columna = 1; columna <= maxColumna; columna++) {
			const cuadricula = document.createElement("div");
			cuadricula.classList.add("cuadricula");
			contenedor.appendChild(cuadricula);
			cuadricula.style.gridRow = fila.toString();
			cuadricula.style.gridColumn = columna.toString();
			cuadricula.addEventListener("click", () => {
			
			window.location.href = `../arboles/planoforminsertar?filax=${fila}&columnax=${columna}&idfincax=${idfinca}`;
		})
		}
	}

	// Colocar los árboles en las celdas correspondientes
	for (let arbol of data) {
		const tree = document.createElement("div");
		tree.classList.add("arbol");
		tree.textContent = arbol.idarbol;
		tree.style.backgroundColor = arbol.variedad.color;

		if (arbol.estado === "Muerto") {
			tree.style.backgroundColor = "black";
		}
		tree.style.gridRow = (arbol.fila).toString();
		tree.style.gridColumn = arbol.columna.toString();

		tree.dataset.idarbol = arbol.idarbol;

		tree.addEventListener("click", () => {
			const idarbol = tree.dataset.idarbol;
			window.location.href = `../arboles/formmodificar?idarbol=${idarbol}`;
		});

		contenedor.appendChild(tree);
	}
}
		
	
recogerDatos();