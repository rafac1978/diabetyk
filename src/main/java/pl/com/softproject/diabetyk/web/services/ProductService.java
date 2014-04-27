/**
 * This file is part of diabetyk-web.
 *
 * (c) 2014 SoftProject
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package pl.com.softproject.diabetyk.web.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import pl.com.softproject.diabetyk.web.model.Product;
import pl.com.softproject.diabetyk.web.model.ProductCategory;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public interface ProductService {

    void saveProduct(Product product);

    Iterable<ProductCategory> findAllCategories();

    Iterable<ProductCategory> findAllCategoriesOrdered();

    Page<Product> findProductsForModeration(String author, Pageable pr);

    Page<Product> findForUser(String author, Pageable pr);
}
