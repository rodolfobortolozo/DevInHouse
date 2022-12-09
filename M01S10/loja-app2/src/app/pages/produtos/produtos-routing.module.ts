import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProdutoCadastrarComponent } from './produto-cadastrar/produto-cadastrar.component';
import { ProdutoAvaliarComponent } from './produto-detalhar/produto-avaliar/produto-avaliar.component';
import { ProdutoDetalharComponent } from './produto-detalhar/produto-detalhar.component';
import { ProdutoEditarComponent } from './produto-editar/produto-editar.component';
import { ProdutoListarComponent } from './produto-listar/produto-listar.component';

const routes: Routes = [
  {
    path: 'produtos',
    children: [
      {
        path: '',
        component: ProdutoListarComponent
      },
      {
        path: 'listar',
        component: ProdutoListarComponent
      },
      {
        path: 'cadastrar',
        component: ProdutoCadastrarComponent
      },
      {
        path: 'editar',
        component: ProdutoEditarComponent
      },
      {
        path: 'detalhar',
        children: [
          {
            path: '',
            component: ProdutoDetalharComponent
          },
          {
            path: 'avaliar',
            component: ProdutoAvaliarComponent
          },
        ]
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProdutosRoutingModule { }
