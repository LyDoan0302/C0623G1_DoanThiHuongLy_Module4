package com.example.booklibrary.controller;

import com.example.booklibrary.exception.ExceptionHandle;
import com.example.booklibrary.model.Book;
import com.example.booklibrary.model.RentingBook;
import com.example.booklibrary.service.IBookService;
import com.example.booklibrary.service.IRentingBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IRentingBookService rentingBookService;
    @RequestMapping(method = RequestMethod.GET)
    public String showBookList(@PageableDefault(value = 5, sort = "title",
            direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        model.addAttribute("books", bookService.findAll(pageable));
        return "index";
    }
    @GetMapping("/{id}/view")
    public ModelAndView viewBookByDetail(@PathVariable Long id){
        return new ModelAndView("view", "book", bookService.findById(id));

    }
    @GetMapping("/{id}/rent")
    public String rentBook(@PathVariable Long id, Model model) throws ExceptionHandle {
        Book book = bookService.findById(id);
        if(book.getQuantity() == 0) {
            return "errorNotAvailableBook";
        } else {
            Long rentingCode;
            do{
                rentingCode = (long)Math.floor(Math.random() * (99999 - 1 + 1) + 1);
            } while ( (rentingBookService.findRentingBooksByRentingId(rentingCode) != null));

            book.setQuantity(book.getQuantity()-1);
            RentingBook rentingBook = new RentingBook();
            rentingBook.setRentingId(rentingCode);
            rentingBook.setBook(book);
            rentingBookService.save(rentingBook);
            model.addAttribute("book", book);
            model.addAttribute("rentingBook", rentingBook);
            return "rentDetail";
        }
    }
   @GetMapping("/rentManager")
    public String showRentingBookList(Model model){
        List<RentingBook> rentingBookList = rentingBookService.findAll();
        List<RentingBook> notReturnRentingBooks = new ArrayList<>();
        for(RentingBook rtb: rentingBookList) {
            if(!rtb.isReturn()){
                notReturnRentingBooks.add(rtb);
            }
        }
        model.addAttribute("rentingList",notReturnRentingBooks);
        return "rentingList";
   }

   @GetMapping("/return")
    public String showReturnForm(){
        return "returnForm";
   }
//   @GetMapping("/{rentingId}/return")
//    public String returnBook(@PathVariable Long rentingId){
//        RentingBook rentingBook = rentingBookService.findById(rentingId);
//        Book book = rentingBook.getBook();
//        book.setQuantity(book.getQuantity() + 1);
//        rentingBookService.deleteRentingBook(rentingId);
//        return "redirect:/rentManager";
//   }
   @PostMapping("/return")
    public String returnBook(@RequestParam Long rentingId, Model model) throws ExceptionHandle {
       RentingBook rentingBook = rentingBookService.findRentingBooksByRentingId(rentingId);
       if(rentingBook.isReturn()){
           return "errorNotExistRentingId";
       } else {
           rentingBook.setReturn(true);
           Book book = rentingBook.getBook();
           book.setQuantity(book.getQuantity() + 1);
//           rentingBookService.deleteRentingBook(rentingId);
           bookService.update(book);
           model.addAttribute("success","Return book successfully!");
           return "returnForm";
       }

   }


}
