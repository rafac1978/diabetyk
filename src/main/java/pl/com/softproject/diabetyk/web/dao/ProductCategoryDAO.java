/**
 * This file is part of diabetyk-web.
 *
 * (c) 2014 SoftProject
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package pl.com.softproject.diabetyk.web.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.com.softproject.diabetyk.web.model.ProductCategory;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public interface ProductCategoryDAO extends CrudRepository<ProductCategory, Long> {
    @Query("from ProductCategory order by name")
    public Iterable<ProductCategory> findAllOrdered();
}
