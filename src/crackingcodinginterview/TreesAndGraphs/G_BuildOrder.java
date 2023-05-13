package crackingcodinginterview.TreesAndGraphs;

import crackingcodinginterview.TreesAndGraphs.collection.GenericNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
 * projects, where the second project is dependent on the first project). All of a project's dependencies
 * must be built before the project is. Find a build order that will allow the projects to be built. If there
 * is no valid build order, return an error.
 * EXAMPLE
 * Input:
 * projects: a, b, c, d, e, f
 * dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 * Output: f, e, a, b, d, c
 */
public class G_BuildOrder {

    public static void main(String[] args) {
        buildOrder();
    }

    public static void buildOrder() {
        final List<String> projects = List.of("a", "b", "c", "d", "e", "f");

        final List<ProjectDependency> dependencies = List.of(
                new ProjectDependency("a", "d"),
                new ProjectDependency("f", "b"),
                new ProjectDependency("b", "d"),
                new ProjectDependency("f", "a"),
                new ProjectDependency("d", "c"));

        System.out.println(solution(projects, dependencies));
    }

    private static List<String> solution(final List<String> projects, final List<ProjectDependency> dependencies) {
        final List<GenericNode<String>> projectNodes = makeProjectNodes(projects, dependencies);
        final List<String> inOrderProjects = new ArrayList<>();
        final Set<String> resolvedDependencies = new HashSet<>();

        int countResolvedDependenciesByCycle;
        do {
            countResolvedDependenciesByCycle = getCountResolvedDependenciesByCycle(projectNodes, inOrderProjects, resolvedDependencies);
        } while (inOrderProjects.size() != projects.size() || countResolvedDependenciesByCycle == 0);

        return inOrderProjects;
    }

    private static List<GenericNode<String>> makeProjectNodes(final List<String> projects,
                                                              final List<ProjectDependency> dependencies) {
        final List<GenericNode<String>> projectNodes = new ArrayList<>();

        for (String project : projects) {
            projectNodes.add(new GenericNode<>(project));
        }

        for (GenericNode<String> projectNode : projectNodes) {
            final String projectName = projectNode.getValue();

            for (ProjectDependency projectDependency : dependencies) {
                if (projectDependency.dependent.equals(projectName)) {
                    final GenericNode<String> parentProjectNode = projectNodes.stream()
                            .filter(n -> n.getValue().equals(projectDependency.dependency))
                            .findFirst()
                            .get();

                    projectNode.addParent(parentProjectNode);
                }
            }
        }

        return projectNodes;
    }

    private static int getCountResolvedDependenciesByCycle(final List<GenericNode<String>> projectNodes,
                                                           final List<String> inOrderProjects,
                                                           final Set<String> resolvedDependencies) {
        int countResolvedDependenciesByCycle = 0;
        for (GenericNode<String> projectNode : projectNodes) {
            countResolvedDependenciesByCycle += getCountResolvedDependenciesByCycle(inOrderProjects, resolvedDependencies, projectNode);
        }
        return countResolvedDependenciesByCycle;
    }

    private static int getCountResolvedDependenciesByCycle(final List<String> inOrderProjects,
                                                           final Set<String> resolvedDependencies,
                                                           final GenericNode<String> projectNode) {
        int countResolvedDependencies = 0;
        final List<GenericNode<String>> parents = projectNode.getParents();
        final String project = projectNode.getValue();

        if (!inOrderProjects.contains(project)) {
            if (parents.isEmpty()) {
                inOrderProjects.add(project);
                resolvedDependencies.add(project);
                countResolvedDependencies++;
            } else {
                final Set<String> parentProjects = parents.stream()
                        .map(GenericNode::getValue)
                        .collect(Collectors.toSet());

                if (resolvedDependencies.containsAll(parentProjects)) {
                    inOrderProjects.add(project);
                    resolvedDependencies.add(project);
                    countResolvedDependencies++;
                }
            }
        }
        return countResolvedDependencies;
    }


    public record ProjectDependency(String dependency, String dependent) {
    }
}