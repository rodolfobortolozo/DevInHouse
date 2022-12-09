import { Component } from '@angular/core';
import { Router } from '@angular/router';

interface Produto {
  id: number;
  titulo: string;
  descricao: string;
  urlImagem: string;
}

@Component({
  selector: 'lja-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent {
  produtos: Produto[] = [
    {
      titulo: 'TV',
      descricao: 'Smart TV 50” Crystal 4K Samsung 50AU7700 - Wi-Fi Bluetooth HDR Alexa Built in 3 HDMI 1 USB',
      id: 1,
      urlImagem: 'https://a-static.mlcdn.com.br/280x210/smart-tv-50-crystal-4k-samsung-50au7700-wi-fi-bluetooth-hdr-alexa-built-in-3-hdmi-1-usb/magazineluiza/193441200/0fc5facd981c5c79492fd4e96068712a.jpg'
    },
    {
      titulo: 'Secadora',
      descricao: 'Escova Secadora Mondial Cerâmica 1200W - com Íons 3 Velocidades Golden Rose ES-02 da Modial',
      id: 2,
      urlImagem: 'https://a-static.mlcdn.com.br/280x210/escova-secadora-mondial-ceramica-1200w-com-ions-3-velocidades-golden-rose-es-02/magazineluiza/108508600/4a5b64d8cff666311d0bbe647d5c066d.jpg'
    },
    {
      titulo: 'Ventilador',
      descricao: 'Ventilador de Mesa Mondial Super Power VSP-40-B - 40cm 3 Velocidades da Mondial 2S',
      id: 3,
      urlImagem: 'https://a-static.mlcdn.com.br/800x560/ventilador-de-mesa-mondial-super-power-vsp-40-b-40cm-3-velocidades/magazineluiza/231203900/2a3dbec9933ac4545ac5e5e179e1c9e0.jpg'
    },
  ]

  constructor(private router: Router) {
  }

  comprarAgora(nomeProduto: string) {
    console.log(`Item ${nomeProduto} comprado com sucesso!`);
  }

  adicionarAoCarrinho() {
    console.log('Adicionado ao carrinho!');
  }

  navegar(id: number) {
    this.router.navigate(['/contato', id]);
  }
}
