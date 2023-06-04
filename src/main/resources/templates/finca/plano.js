//Recocgemos el parametro de la url
const params = new URLSearchParams(window.location.search);
const idfinca = params.get("idfinca");
//Funcion para recoger la url de la id finca para obtener los arboles
async function recogerDatos() {
	const response = await fetch(`https://alberto-souto-fincas.herokuapp.com/fincas/fincaplano/${idfinca}`);
	const data = await response.json();
	sacarDatos(data);
}
//Función para sacar los datos, los arboles
function sacarDatos(data) {
	const contenedor = document.querySelector(".contenedor");
	contenedor.innerHTML = "";
	contenedor.style.display = "grid";
	contenedor.style.gridAutoRows = "1fr"; // Establecer altura igual para todas las filas
	contenedor.style.gridAutoColumns = "1fr"; // Establecer ancho igual para todas las columnas
	for (let arbol of data) { 
		//Creamos las celdas de los arboles
		const tree = document.createElement("div");
		tree.classList.add("arbol");
		tree.textContent = arbol.idarbol;
		//Estilo de las celdas con el color de variedad
		tree.style.backgroundColor = `${arbol.variedad.color}`;
		//Cambiamos el color de la celda segun el estado del arbol
		if(arbol.estado=== "Muerto"){
			tree.style.backgroundColor ='black';
		}
		//Indicando el estilo de la grid para colocación correcta al visualizarlo
		tree.style.gridRow = (-arbol.fila); //le damos valor negativo para que empieze de abajo a arriba
		tree.style.gridColumn = arbol.columna;
		
		//Para hacer referencia a la base de datos y poder usarlo en el controlador
		 tree.dataset.idarbol = arbol.idarbol;
		//Añadimos un evento para ir al arbol haciendo click sobre él
		tree.addEventListener("click", () => {
          const idarbol = tree.dataset.idarbol;
          window.location.href = `mostrarArbol?idarbol=${idarbol}`; // redirige a otra página pasando el id del árbol como parámetro en la URL
        });
		//Añadimos al html
		
		contenedor.appendChild(tree);
		
	}
}

recogerDatos();