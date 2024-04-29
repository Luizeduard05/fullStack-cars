import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { CardsCarComponent } from './components/cards-car/cards-car.component';
import { AddCarComponent } from './components/add-car/add-car.component';
import { EditCarComponent } from './components/edit-car/edit-car.component';

const routes: Routes = [
  {path: '', component: CardsCarComponent},
  {path: 'addCar', component: AddCarComponent},
  {path: 'dadosCar', component: EditCarComponent},
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
