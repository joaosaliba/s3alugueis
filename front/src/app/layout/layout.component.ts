import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AngularMaterialModule } from '../plugins/angular-material/angular-material.module';
import { RouterOutlet } from '@angular/router';

@Component({
  standalone: true,
  imports: [CommonModule,RouterOutlet,AngularMaterialModule],
  templateUrl: './layout.component.html',
  styleUrl: './layout.component.css'
})
export class LayoutComponent {

}
