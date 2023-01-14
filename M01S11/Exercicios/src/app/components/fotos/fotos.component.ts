import { Component } from '@angular/core';

@Component({
  selector: 'app-fotos',
  templateUrl: './fotos.component.html',
  styleUrls: ['./fotos.component.css']
})
export class FotosComponent {
  arrayFotos: any = [
    {
      url: "https://www.florence.edu.br/wp-content/uploads/2022/08/Imagem-Materia_Dia-do-Cachorro-1024x683.png",
      description:"Cachorro maneiro"
    },
    {
      url: "https://thumbs.dreamstime.com/b/imagem-animal-engra%C3%A7ada-de-um-girafa-fresco-que-veste-um-chap%C3%A9u-e-uma-venda-do-pirata-com-ossos-cruzados-54133024.jpg",
      description:"Girafa pirata"
    },
    {
      url: "http://www.portaldosanimais.com.br/wp-content/uploads/2016/12/foto-engra%C3%A7ada-de-camelo-e1481218897505.jpg",
      description:"Camelo beijoqueiro"
    },
    {
      url: "https://img.r7.com/images/2014/08/19/330m1oxn8v_7sbr00ty8n_file?dimensions=771x420&no_crop=true",
      description:"Tubarão risonho"
    },
    {
      url: "https://gooutside.com.br/wp-content/uploads/sites/3/2018/09/comedy-wildlife-photography-awards-finalists-2018-7-5b9b575e04c57__880.jpg",
      description:"Esquilo ginasta"
    }
  ]

}
