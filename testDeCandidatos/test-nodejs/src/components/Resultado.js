import React from "react";

export default function Resultado({ preguntas, respuestas }) {
  const letras = ["A", "B", "C", "D"]; // Letras para las opciones

  // Calcular puntaje
  const puntaje = preguntas.filter(
    (p) => respuestas[p.id] === p.respuesta_correcta
  ).length;

  // Calcular porcentaje
  const porcentaje = (puntaje / preguntas.length) * 100;

  // Determinar si aprobó
  const aprobado = porcentaje >= 70; // >=70% es aprobado

  return (
    <div>
      <h2>Resultado: {puntaje} / {preguntas.length}</h2>
      <h3>Porcentaje: {porcentaje.toFixed(2)}%</h3>
      <h3 style={{ color: aprobado ? "green" : "red" }}>
        {aprobado ? "¡Aprobaste el examen!" : "No aprobaste el examen"}
      </h3>

      <h3>Respuestas:</h3>
      <ul style={{ listStyle: "none", padding: 0 }}>
        {preguntas.map((p) => {
          // Letra de la respuesta del usuario
          const tuRespuestaIndex = p.opciones.indexOf(respuestas[p.id]);
          const letraTuRespuesta = tuRespuestaIndex !== -1 ? letras[tuRespuestaIndex] : "-";

          // Letra de la respuesta correcta
          const correctaIndex = p.opciones.indexOf(p.respuesta_correcta);
          const letraCorrecta = correctaIndex !== -1 ? letras[correctaIndex] : "-";

          return (
            <li key={p.id} style={{ marginBottom: "15px" }}>
              <strong>{p.texto}</strong><br />
              Correcta: {letraCorrecta}) {p.respuesta_correcta} <br />
              Tu respondiste: {letraTuRespuesta}) {respuestas[p.id] || "No respondió"}
            </li>
          );
        })}
      </ul>
    </div>
  );
}
