/*
 * SonarQube :: GitHub Plugin
 * Copyright (C) 2015 SonarSource
 * sonarqube@googlegroups.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.github;

import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.fs.InputFileFilter;

/**
 * Filter files to analyze to keep only files referenced in the pull request.
 *
 */
public class PullRequestInputFileFilter implements InputFileFilter {

  private final GitHubPluginConfiguration gitHubPluginConfiguration;
  private final PullRequestFacade pullRequestFacade;

  public PullRequestInputFileFilter(GitHubPluginConfiguration gitHubPluginConfiguration, PullRequestFacade pullRequestFacade) {
    this.gitHubPluginConfiguration = gitHubPluginConfiguration;
    this.pullRequestFacade = pullRequestFacade;
  }

  @Override
  public boolean accept(InputFile f) {
    return !gitHubPluginConfiguration.isEnabled() || pullRequestFacade.hasFile(f);
  }

}
