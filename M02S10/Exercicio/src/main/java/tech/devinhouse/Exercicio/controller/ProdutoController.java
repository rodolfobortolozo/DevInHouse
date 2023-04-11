package tech.devinhouse.Exercicio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

  @GetMapping String getProduto(Model model){
    model.addAttribute("nome", "Produto");
    model.addAttribute("descricao", "Descrição do Produto");
    model.addAttribute("dtaLancto", "03/04/1989");
    model.addAttribute("vlrProduto", "123,45");

    return "produto";
  }
}
