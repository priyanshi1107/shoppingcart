package com.assignment.shoppingcart.service;

import com.assignment.shoppingcart.dao.HomeRepository;
import com.assignment.shoppingcart.dto.StaticProductsDto;
import com.assignment.shoppingcart.entity.StaticProducts;
import com.assignment.shoppingcart.exceptions.BadRequestException;
import com.assignment.shoppingcart.exceptions.ProductsNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeRepository homeRepository;
    @Autowired
    private ModelMapper modelMapper;

    private static final Pattern PRODUCT_NAME_PATTERN = Pattern.compile("[a-zA-Z0-9. ]+");

    @Override
    public StaticProducts convertDtoToEntity(StaticProductsDto staticProductsDto) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(staticProductsDto, StaticProducts.class);
    }

    @Override
    public StaticProductsDto convertEntityToDto(StaticProducts staticProducts) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(staticProducts, StaticProductsDto.class);
    }

    @Override
    public List<StaticProducts> saveListOfStaticProducts(List<StaticProducts> staticProductsList) {
        List<StaticProducts> validatedProducts = staticProductsList.stream()
                .peek(this::validateProductName)
                .collect(Collectors.toList());

        // Save only the validated products
        return homeRepository.saveAll(validatedProducts);    }

    private void validateProductName(StaticProducts staticProducts) {
        if (!PRODUCT_NAME_PATTERN.matcher(staticProducts.getProductName()).matches()) {
            throw new BadRequestException("Invalid product name format: " + staticProducts.getProductName());
        }
    }
    @Override
    public List<StaticProductsDto> getAllStaticProducts() {
        List<StaticProductsDto> staticProductsDtoList = homeRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        if (staticProductsDtoList.isEmpty()) {
            throw new ProductsNotFoundException();
        }

        return staticProductsDtoList;
    }
}
