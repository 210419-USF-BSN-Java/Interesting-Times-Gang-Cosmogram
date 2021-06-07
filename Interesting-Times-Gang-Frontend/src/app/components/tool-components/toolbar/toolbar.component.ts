import { Component, Input, OnInit, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { accountTools } from '../account-tools';
import { albumsTools } from '../albumsTools';
import { infoTools } from '../infoTools';
import { searchTools } from '../search-tools';
import { Tool } from '../tool';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {
  @Input() show: Boolean = false;
  accountToolbox: Tool[] = accountTools;
  searchToolbox: Tool[] = searchTools;
  albumsToolbox: Tool[] = albumsTools;
  infoToolbox: Tool[] = infoTools;
  selectedToolbox: string = "";
  @Output() notifyNavBarTitle = new EventEmitter();
  @Input() selectedTool?: Tool;
  @Output() giveNavbarTool = new EventEmitter<Tool>();


  constructor() { }

  ngOnInit(): void {
  }

  selectToolbox(toolBoxTitle: string): void {
    this.selectedToolbox = toolBoxTitle;
    this.notifyNavBarTitle.emit(toolBoxTitle);
  }

  acceptTool(tool: Tool){
    this.selectedTool = tool;
    this.giveNavbarTool.emit(this.selectedTool);
  }
}
