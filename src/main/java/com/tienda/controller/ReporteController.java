package com.tienda.controller;

import com.tienda.dao.CategoriaDao;
import com.tienda.dao.ProductoDao;
import com.tienda.dao.UsuarioDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pruebas/reportes")
public class ReporteController {

    @Autowired
    private CategoriaDao categoriaDao;

    @Autowired
    private ProductoDao productoDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @GetMapping("/productosPorCategoria")
    public String productosPorCategoria(Model model) {
        model.addAttribute("categorias", categoriaDao.findAll());
        return "/reportes/productosPorCategoria";
    }

    @PostMapping("/productosPorCategoria")
    public String productosPorCategoriaResultado(@RequestParam("idCategoria") Long idCategoria, Model model) {
        var productos = productoDao.findByCategoriaIdCategoria(idCategoria);
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categoriaDao.findAll());
        model.addAttribute("idCategoriaSeleccionada", idCategoria);
        return "/reportes/productosPorCategoria";
    }

    @GetMapping("/facturasPorUsuario")
    public String facturasPorUsuario(Model model) {
        List<Object[]> resultados = usuarioDao.contarFacturasPorUsuario();
        model.addAttribute("resultados", resultados);
        return "/reportes/facturasPorUsuario";
    }
}
