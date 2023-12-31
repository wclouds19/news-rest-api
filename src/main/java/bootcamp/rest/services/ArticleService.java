package bootcamp.rest.services;

import bootcamp.rest.models.entities.Article;
import bootcamp.rest.models.repos.ArticleRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleService {
    @Autowired
    private ArticleRepo articleRepo; 

    //This Method Run Can Be Create & Update
    public Article create(Article article){
        return articleRepo.save(article);
    }

    public Article findOneArticle(Long Id){

        Optional<Article> article = articleRepo.findById(Id);
        if(!article.isPresent()){
            throw new RuntimeException("Article not found for this id :: " + Id);        
        }
        return article.get(); 
    }

    public Iterable<Article> findAllArticle(){
        return articleRepo.findAll();
    }

    public void removeOneArticle(Long Id){
        Optional<Article> article = articleRepo.findById(Id);
        if(!article.isPresent()){
            throw new RuntimeException("Article not found for this id :: " + Id); 
        }
        articleRepo.deleteById(Id);
    }

    //Call the Custom Query Method Find Article by Title 
    public List<Article> findByTitle(String title){
        return articleRepo.findByTitle("%"+title+"%");
    }

    //Call the Custom Query Method to Find Article by Category ID
    public List<Article> findByCategory(Long Id){
        return articleRepo.findByCategory(Id);
    }

    //Call the Custom  Method to Find Article by Author ID
    public List<Article> findByAuthor(Long Id){
        return articleRepo.findByAuthor(Id);
    }
}
