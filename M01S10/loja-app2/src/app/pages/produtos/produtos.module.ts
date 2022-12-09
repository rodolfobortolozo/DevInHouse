import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProdutosRoutingModule } from './produtos-routing.module';
import { ProdutoCadastrarComponent } from './produto-cadastrar/produto-cadastrar.component';
import { ProdutoListarComponent } from './produto-listar/produto-listar.component';
import { ProdutoEditarComponent } from './produto-editar/produto-editar.component';
import { ProdutoDetalharComponent } from './produto-detalhar/produto-detalhar.component';
import { ProdutoAvaliarComponent } from './produto-detalhar/produto-avaliar/produto-avaliar.component';


@NgModule({
  declarations: [
    ProdutoCadastrarComponent,
    ProdutoListarComponent,
    ProdutoEditarComponent,
    ProdutoDetalharComponent,
    ProdutoAvaliarComponent
  ],
  imports: [
    CommonModule,
    ProdutosRoutingModule
  ]
})
export class ProdutosModule { }
