import { CalculadoraDeArea } from "./CalculadoraDeArea.js";

const quadA = new CalculadoraDeArea("quadrado", 6, 6);
const areaQA = quadA.Calcular();
console.log(areaQA); // 36

const triangB = new CalculadoraDeArea("triangulo", 8, 7);
const areaTB = triangB.Calcular();
console.log(areaTB); // 28

const retanguloB = new CalculadoraDeArea("retangulo", 8, 9);
const areaRet = retanguloB.Calcular();
console.log(areaRet); // Tipo Inválido