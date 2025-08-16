package br.com.fiap.spring_mvc.controller;

import br.com.fiap.spring_mvc.entity.Livro;
import br.com.fiap.spring_mvc.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    LivroService livroService;

    @GetMapping("/lista")
    public String listarLivros(Model model) {
        List<Livro> livros = livroService.readLivros();
        model.addAttribute("ListaLivros", livros);
        return "livroLista";
    }

    @GetMapping("/cadrasto")
    public String cadastroLivro(Model model) {
        model.addAttribute("Livro",new Livro());
        return "LivroCadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarLivro(Livro livro, Model model) {
        livroService.createLivro(livro);
        return listarLivros(model);
    }
}
