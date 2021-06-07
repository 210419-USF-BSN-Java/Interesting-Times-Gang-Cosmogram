import { Component, Input, OnInit, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { Tool } from '../tool';

@Component({
  selector: 'app-toolbox',
  templateUrl: './toolbox.component.html',
  styleUrls: ['./toolbox.component.css']
})
export class ToolboxComponent implements OnInit {
  @Input() title?: string;
  @Input() toolbox?: Tool[];
  @Input() selectedToolbox?: string;
  @Output() tellToolBar = new EventEmitter<string>();
  @Output() tellDashboard = new EventEmitter<string>();
  @Output() giveToolbarTool = new EventEmitter<Tool>();

  constructor() { }

  ngOnInit(): void {
  }

  showThisToolbox() {
    this.tellToolBar.emit(this.title);
  }

  startPassingTool(tool: Tool) {
    // this.tellDashboard.emit(tool.title);
    this.giveToolbarTool.emit(tool);
  }

}
