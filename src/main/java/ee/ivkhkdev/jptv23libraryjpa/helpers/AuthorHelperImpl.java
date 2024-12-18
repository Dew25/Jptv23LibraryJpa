package ee.ivkhkdev.jptv23libraryjpa.helpers;

import ee.ivkhkdev.jptv23libraryjpa.entity.Author;
import ee.ivkhkdev.jptv23libraryjpa.input.Input;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
            modifiedAurhor = changeLastname(modifiedAurhor);
            modifiedAurhor = changeAvailable(modifiedAurhor);
            return Optional.of(modifiedAurhor);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    private Author changeAvailable(Author modifiedAurhor) {
        if(modifiedAurhor.isAvailable()){
            System.out.println("Удалить (выключить) автора (y/n): ");
            if("y".equals(input.nextLine())){
                modifiedAurhor.setAvailable(false);
            }
        }else{
            System.out.println("Добавить (включить) автора (y/n): ");
            if("y".equals(input.nextLine())){
                modifiedAurhor.setAvailable(true);
            }
        }
        return modifiedAurhor;
    }

    private Author changeLastname(Author modifiedAurhor) {
        System.out.println("Фамилия автора: "+modifiedAurhor.getLastname());
        System.out.print("Изменить (y/n): ");
        if("y".equals(input.nextLine())){
            System.out.print("Новая фамилия автора: ");
            modifiedAurhor.setLastname(input.nextLine());
        }
        return modifiedAurhor;
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
        this.printList(authors,true);
        System.out.print("Выбери автора для изменения: ");
        return (long) input.nextInt();
    }

    @Override
    public List<Long> listIdAuhtorsBook(List<Author> authors) {
        System.out.print("Укажите сколько авторов в книге: ");
        int countAuthorsBook = input.nextInt();
        this.printList(authors,true);
        List<Long> idAuthorsBook = new ArrayList<>();
        for (int i = 0; i < countAuthorsBook; i++) {
            System.out.printf("Выберите автора %d is %d: ",i+1,countAuthorsBook);
            idAuthorsBook.add((long) input.nextInt());
        }
        return idAuthorsBook;
    }

    @Override
    public boolean printList(List<Author> authors,boolean enableAll) {
        if(authors.isEmpty()){
            return false;
        }
        /*
         * Если автор выключен (author.available = false), а печатать надо всех (enabledAll=true),
         * добавляем к автору строку "(выключен)"
         */
        for (int i = 0; i < authors.size(); i++) {
            String isEnabled = "";
            if(enableAll){
                if(!authors.get(i).isAvailable()) {
                    isEnabled = "(выключен)";
                }
            }else{
               if(!authors.get(i).isAvailable()){
                   continue;
               }
            }
            System.out.printf("%d. %s %s. %s%n",
                    authors.get(i).getId(),
                    authors.get(i).getFirstname(),
                    authors.get(i).getLastname(),
                    isEnabled
            );
        }
        return true;
    }

}
