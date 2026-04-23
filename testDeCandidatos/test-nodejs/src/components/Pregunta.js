import React from "react";

export default function Pregunta({ pregunta, handleChange, respuestas }) {
  const letras = ["A", "B", "C", "D"]; // Letras para las opciones

  return (
    <div style={{ marginBottom: "20px" }}>
      <h3>{pregunta.texto}</h3>
      {pregunta.opciones.map((opcion, index) => (
        <label
          key={index}
          style={{
            display: "block",
            backgroundColor: "#f8f9fa",
            padding: "10px",
            borderRadius: "8px",
            marginBottom: "5px",
            cursor: "pointer",
          }}
        >
          <input
            type="radio"
            name={`pregunta-${pregunta.id}`} // <-- CORREGIDO: ahora funciona
            value={opcion}
            checked={respuestas[pregunta.id] === opcion}
            onChange={() => handleChange(pregunta.id, opcion)}
            style={{ marginRight: "10px" }}
          />
          <strong>{letras[index]})</strong> {opcion} {/* letra antes de la opción */}
        </label>
      ))}
    </div>
  );
}
