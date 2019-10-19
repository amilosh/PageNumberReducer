package by.milosh.controller;

import by.milosh.dto.PageDto;
import by.milosh.exception.IncorrectFormatException;
import by.milosh.service.ReducerService;
import by.milosh.validator.PageDtoValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/reducedPageNumbers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ReducerController {

    private ReducerService reducerService;
    private PageDtoValidator pageDtoValidator;

    @GetMapping
    public String reduceNumbers(@Valid @ModelAttribute PageDto pageDto) throws IncorrectFormatException {
        pageDtoValidator.validate(pageDto.getRawPageNumbers());
        return reducerService.reduce(pageDto.getRawPageNumbers());
    }
}
