import javafx.scene.layout.Priority;

import javax.persistence.*;
import javax.persistence.metamodel.Type;
import java.sql.Date;

@Entity
@Table(name = "task", schema = "public")
public class Task {

    private Long taskId;
    private User user;
    private Date taskDate;
    private String name;
    private String definition;
    private Priority priority;
    private Type type;

    @Id
    @SequenceGenerator(name = "tasks_seq", sequenceName = "tasks_task_id_seq", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_seq")
    @Column(name = "task_id", unique = true, nullable = false)
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "task_date")
    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "definition")
    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

}