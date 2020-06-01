package web_shop.exercise.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web_shop.exercise.Domain.Product;
import web_shop.exercise.Service.IProductService;

@Controller
public class ProductController
{
    @Autowired //Runtime inject implemented class
    IProductService IProductService;

    @GetMapping({"", "/"})
    public String indexPage(Model model) //interface Model - carries data
    {
        model.addAttribute("products", IProductService.readAll());
        return "/index";
    }

    @GetMapping("/create")
    public String create(Product product, Model model)
    {
        model.addAttribute("products", product);
        return "/create";
    }

    /**
     * @ModelAttribute binds form Product to domain Product
     * @param product
     * @return String
     */
    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product)
    {
        IProductService.create(product);
        return "redirect:/";
    }

    /**
     * use @PathVariable to fetch id from list
     * @param id
     * @param model
     * @return String
     */
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("products", IProductService.read(id));
        return "/update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product)
    {
        IProductService.update(product);
        return "redirect:/";
    }

    //use @PathVariable to fetch id from list
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id)
    {
        IProductService.delete(id);
        return "redirect:/";
    }
}

