import { ICor } from "./ICor";
import { IMarca } from "./IMarca";

export interface ICarro {
    id?: number;
    nome_carro: string;
    ano_fabricacao: number;
    ano_modelo: number;
    modelo_carro: string;
    marca: IMarca;
    cores: ICor[];
}


