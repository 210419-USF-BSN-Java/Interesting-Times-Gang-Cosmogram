import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { UpdateInfoComponent } from './components/update-info/update-info.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ToolbarComponent } from './components/tool-components/toolbar/toolbar.component';
import { ToolboxComponent } from './components/tool-components/toolbox/toolbox.component';
import { SingleImageComponent } from './components/single-image/single-image.component';
import { MultiImageComponent } from './components/multi-image/multi-image.component';
import { SearchImageComponent } from './components/search-image/search-image.component';
import { SearchImageDateComponent } from './components/search-image-date/search-image-date.component';
import { SearchImageRangeComponent } from './components/search-image-range/search-image-range.component';
import { SearchImageTagComponent } from './components/search-image-tag/search-image-tag.component';
import { SearchImageRandomComponent } from './components/search-image-random/search-image-random.component';
import { LogoutComponent } from './components/logout/logout.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    RegisterComponent,
    UpdateInfoComponent,
    NavbarComponent,
    ToolbarComponent,
    ToolboxComponent,
    SingleImageComponent,
    MultiImageComponent,
    SearchImageComponent,
    SearchImageDateComponent,
    SearchImageRangeComponent,
    SearchImageTagComponent,
    SearchImageRandomComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
