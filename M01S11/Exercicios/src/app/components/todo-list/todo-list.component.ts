import { Component, ViewChild } from '@angular/core';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent {
  todo:string = ''
  todoList:string[] = []

  addTodo() {
    if (this.todo.length) {
      this.todoList.push(this.todo)
      this.todo = ''
    }
  }
}
