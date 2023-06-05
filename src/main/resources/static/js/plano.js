// Recogemos el parámetro de la URL
const params = new URLSearchParams(window.location.search);
const idFinca = params.get("idfinca");

// Función para obtener los datos de los árboles
async function obtenerDatosArboles() {
  const response = await fetch(`https://alberto-souto-fincas.herokuapp.com/fincas/plano/${idFinca}`);
  const datos = await response.json();
  mostrarDatosArboles(datos);
}

// Función para mostrar los datos de los árboles
function mostrarDatosArboles(datos) {
  const contenedor = document.querySelector(".contenedor");
  contenedor.innerHTML = "";
  contenedor.style.display = "grid";

  let maxColumna = 0;
  let maxFila = 0;

  // Obtener los valores máximos de fila y columna
  for (let dato of datos) {
    if (dato.columna > maxColumna) {
      maxColumna = dato.columna;
    }
    if (dato.fila > maxFila) {
      maxFila = dato.fila;
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
        window.location.href = `../arboles/planoforminsertar?filax=${fila}&columnax=${columna}&idfincax=${idFinca}`;
      });
    }
  }

  // Colocar los árboles en las celdas correspondientes
  for (let arbol of datos) {
    const arbolElemento = document.createElement("div");
    arbolElemento.classList.add("arbol");

    switch (arbol.estado.toUpperCase()) {
      case "MUERTO":
        arbolElemento.style.backgroundColor = "black";
        break;
      case "SANO":
        arbolElemento.style.backgroundColor = "lightbrown";
        break;
      case "ENFERMO":
        arbolElemento.style.backgroundColor = "darkgreen";
        break;
    }
    arbolElemento.style.gridRow = arbol.fila.toString();
    arbolElemento.style.gridColumn = arbol.columna.toString();

    arbolElemento.dataset.idArbol = arbol.idarbol;

    arbolElemento.addEventListener("click", () => {
      const idArbol = arbolElemento.dataset.idArbol;
      window.location.href = `../arboles/formmodificar?idarbol=${idArbol}`;
    });

    contenedor.appendChild(arbolElemento);
  }
}

obtenerDatosArboles();