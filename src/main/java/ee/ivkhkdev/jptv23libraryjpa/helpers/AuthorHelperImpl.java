package ee.ivkhkdev.jptv23libraryjpa.helpers;

import ee.ivkhkdev.jptv23libraryjpa.enity.Author;
import ee.ivkhkdev.jptv23libraryjpa.input.Input;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class AuthorHelperImpl implements AuthorHelper{
    private Input input;

    public AuthorHelperImpl(Input input) {
        this.input = input;
    }

    @Override
    public Optional create() {
        try {
            Author author = new Author();
            System.out.print("Имя: ");
            author.setFirstname(input.nextLine());
            System.out.print("Фамилия: ");
            author.setLastname(input.nextLine());
            return Optional.of(author);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<Author> update(Author author) {
        try {
            Author modifiedAurhor = changeFirstname(author);
//            modifiedAurhor = changeLastname(modifiedAurhor);
//            modifiedAurhor = changeAvilable(modifiedAurhor);
            return Optional.of(modifiedAurhor);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    private Author changeFirstname(Author author) {
        System.out.println("Имя автора: "+author.getFirstname());
        System.out.print("Изменить (y/n): ");
        if("y".equals(input.nextLine())){
            System.out.print("Новое имя автора: ");
            author.setFirstname(input.nextLine());
        }
        return author;
    }

    @Override
    public Long getIdModifyAuthor(List<Author> authors){
        this.printList(authors);
        System.out.print("Выбери автора для изменения: ");
        return (long) input.nextInt();
    }

    @Override
    public boolean printList(List<Author> authors) {
        if(authors.isEmpty()){
            return false;
        }
        for (int i = 0; i < authors.size(); i++) {
            if(!authors.get(i).isAvailable()) continue;
            System.out.printf("%d. %s %s.%n",
                    authors.get(i).getId(),
                    authors.get(i).getFirstname(),
                    authors.get(i).getLastname()
            );
        }
        return true;
    }
}
