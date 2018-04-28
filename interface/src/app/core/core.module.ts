import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { SectionsService } from './services/sections.service';
import { TopicsSearchService } from './services/topics-search.service';
import { TopicsService } from './services/topics.service';

@NgModule({
  imports: [HttpClientModule],
  exports: [],
  declarations: [],
  providers: [
    SectionsService,
    TopicsSearchService,
    TopicsService
  ]
})
export class CoreModule {}
