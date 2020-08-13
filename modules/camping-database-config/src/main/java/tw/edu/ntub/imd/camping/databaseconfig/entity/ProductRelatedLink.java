package tw.edu.ntub.imd.camping.databaseconfig.entity;

import lombok.*;
import tw.edu.ntub.imd.camping.databaseconfig.Config;
import tw.edu.ntub.imd.camping.databaseconfig.entity.listener.ProductRelatedLinkListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 商品相關連結
 *
 * @since 1.0.0
 */
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = "productByProductId")
@Entity
@EntityListeners(ProductRelatedLinkListener.class)
@Table(name = "product_related_link", schema = Config.DATABASE_NAME)
public class ProductRelatedLink {
    /**
     * 流水編號
     *
     * @since 1.0.0
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "UNSIGNED")
    private Integer id;

    /**
     * 商品編號
     *
     * @since 1.0.0
     */
    @Column(name = "product_id", nullable = false, columnDefinition = "UNSIGNED")
    private Integer productId;

    /**
     * 是否啟用(0: 否/ 1: 是)
     *
     * @since 1.0.0
     */
    @Getter(AccessLevel.NONE)
    @Column(name = "enable", nullable = false)
    private Boolean enable = true;

    /**
     * 相關連結
     *
     * @since 1.0.0
     */
    @Column(name = "url", length = 600, nullable = false)
    private String url;

    /**
     * 建立時間
     *
     * @since 1.0.0
     */
    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    /**
     * 最後修改時間
     *
     * @since 1.0.0
     */
    @Column(name = "last_modify_date", nullable = false)
    private LocalDateTime lastModifyDate;

    /**
     * 商品
     *
     * @see Product
     * @since 1.0.0
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false, columnDefinition = "UNSIGNED", insertable = false, updatable = false)
    private Product productByProductId;

    public ProductRelatedLink(String url) {
        this.url = url;
    }

    /**
     * 是否啟用(0: 否/ 1: 是)
     *
     * @since 1.0.0
     */
    public Boolean isEnable() {
        return enable;
    }
}
