import React, { useState, useEffect } from "react";
import Pregunta from "./components/Pregunta";
import Resultado from "./components/Resultado";
import preguntasData from "./preguntas.json"; // <-- importamos el JSON local

function App() {
  const [preguntas, setPreguntas] = useState([]);
  const [respuestas, setRespuestas] = useState({});
  const [mostrarResultado, setMostrarResultado] = useState(false);

  useEffect(() => {
    // Cargamos las preguntas directamente desde el JSON local
    setPreguntas(preguntasData);
  }, []);

  const handleChange = (id, valor) => {
    setRespuestas({ ...respuestas, [id]: valor });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setMostrarResultado(true);
  };

  return (
    <div style={{ padding: "20px", maxWidth: "600px", margin: "auto" }}>
      <h1>Test de Node.js</h1>
      {!mostrarResultado ? (
        <form onSubmit={handleSubmit}>
          {preguntas.map((p) => (
            <Pregunta
              key={p.id}
              pregunta={p}
              handleChange={handleChange}
              respuestas={respuestas}
            />
          ))}
          <button type="submit">Enviar Test</button>
        </form>
      ) : (
        <Resultado preguntas={preguntas} respuestas={respuestas} />
      )}
    </div>
  );
}

export default App;
