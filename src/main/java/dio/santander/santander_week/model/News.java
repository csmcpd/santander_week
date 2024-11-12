package dio.santander.santander_week.model;

import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_news")
public class News extends BaseItem {

}
